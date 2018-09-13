using NHibernate;

namespace SalesSystem.Business
{
    public class Context
    {
        public static ISessionFactory SessionFactory { get; set; }
    }
}