using System.Configuration;
using System.IO;
using System.Reflection;
using SalesSystem.Business;
using NUnit.Framework;

namespace SalesSystem
{
    [SetUpFixture]
    public class AssemblyInitializer
    {
        [OneTimeSetUp]
        public static void AssemblyInitialize()
        {
            var baseDir = Path.GetDirectoryName(Assembly.GetExecutingAssembly().Location);
            TestConfiguration.SetupTestVariables(baseDir, connectionString);
            ConfigureNHibernate();
        }

        [OneTimeTearDownAttribute]
        public static void AssemblyCleanup()
        {
          Context.SessionFactory.Dispose();
        }

        private static void ConfigureNHibernate()
        {
            Configurator.Configure(
                true,
                true);
        }

        public static string connectionString
        {
            get
            {
                var connectionString = ConfigurationManager.ConnectionStrings["Connection"].ConnectionString;
                return connectionString;
            }
        }
    }
}