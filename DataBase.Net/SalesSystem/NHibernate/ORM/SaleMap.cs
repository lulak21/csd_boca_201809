using FluentNHibernate.Mapping;
using SalesSystem.Model;

namespace SalesSystem.Business
{
    public class SaleMap : ClassMap<Sale>
    {
        public SaleMap()
        {
            Id(x => x.saleId);
            Map(x => x.saleDate);
            Map(x => x.value);
            Map(x => x.salesmanId);
        }
    }

}