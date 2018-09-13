using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using NHibernate;

namespace SalesSystem.Business
{
    public class ReportGenerator
    {
        public double TotalYearSalesBySalesman(int year, int salesmanId, ISession _session)
        {

            string query = "select sum(v.value) from Sale v where v.salesmanId = :salesmanId and YEAR(v.saleDate) = :year";

            double salesValue = _session.CreateSQLQuery(query)
                .SetParameter("salesmanId", salesmanId)
                .SetParameter("year", year)
                .UniqueResult<double>();

            return salesValue;
        }
    }
}