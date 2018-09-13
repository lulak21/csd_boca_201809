using FluentNHibernate.Cfg;
using FluentNHibernate.Cfg.Db;
using NHibernate.Cfg;
using NHibernate.Tool.hbm2ddl;

namespace SalesSystem.Business
{


    public static class Configurator
    {
        public static void Configure()
        {
            Configure(false, false);
        }

        public static void Configure(bool showSql, bool createDB)
        {
            if (Context.SessionFactory != null)
                return;

            Context.SessionFactory = CreateConfigObjectOnNH()
                .ConfigMapping()
                .ConfigDB(showSql)
                .CreateDB(createDB)
                .BuildSessionFactory();
        }

        private static FluentConfiguration ConfigDB(this FluentConfiguration configFluente, bool showSql)
        {
            configFluente.ConfigurarStringConexao(MsSqlConfiguration.MsSql2005, showSql);
            return configFluente;
        }

        private static FluentConfiguration ConfigMapping(this Configuration config)
        {
            return Fluently.Configure(config)
                .Mappings(m => m.FluentMappings.AddFromAssemblyOf<SaleMap>());
        }

        private static FluentConfiguration CreateDB(this FluentConfiguration configFluente, bool criarBD)
        {
            if (criarBD)
                configFluente.ExposeConfiguration(
                    config =>
                    {
                        new SchemaExport(config).Drop(true, true);
                        new SchemaExport(config).Create(true, true);
                    }
                    );
            return configFluente;
        }

        private static Configuration CreateConfigObjectOnNH()
        {
            var config = new Configuration();
            config.Properties.Add("proxyfactory.factory_class", "NHibernate.ByteCode.Castle.ProxyFactoryFactory, NHibernate.ByteCode.Castle");
            return config;
        }

        private static void ConfigurarStringConexao<TThisConfiguration, TConnectionString>(
            this FluentConfiguration configFluente,
            PersistenceConfiguration<TThisConfiguration, TConnectionString> persistenceConfiguration,
            bool showSql)
            where TThisConfiguration : PersistenceConfiguration<TThisConfiguration, TConnectionString>
            where TConnectionString : ConnectionStringBuilder, new()
        {
            const string connectionStringKey = "Connection";
            if (showSql) persistenceConfiguration.ShowSql();
            persistenceConfiguration.ConnectionString(c => c.FromConnectionStringWithKey(connectionStringKey));
            configFluente.Database(persistenceConfiguration);
        }
    }
}
