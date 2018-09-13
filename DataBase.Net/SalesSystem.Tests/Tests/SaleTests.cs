using System;
using System.Collections.Generic;
using System.Text;
using Gallio.Framework;
using NUnit.Framework;
using NHibernate;
using SalesSystem.Business;
using SalesSystem.Model;
using SalesSystem;

namespace SalesSystem.Tests
{ 
    [TestFixture]
    public class SaleTests : TesteBase
    {
        private ISession _session;
        
        [SetUp]
        public void Initialize()
        {
            _session = Context.SessionFactory.OpenSession();
        }

        [Test]
        public void SalesTotalValueForOneSalesmanOn2018()
        {
            var ano = 1969;
            var idVendedor = 7;
            ReportGenerator gr = new ReportGenerator();
            Assert.AreEqual(300, gr.TotalYearSalesBySalesman(ano, idVendedor, _session));
        }

        [Test]
        public void SalesTotalValueForOneSalesmanId9year1963()
        {
            var ano = 1963;
            var idVendedor = 9;
            ReportGenerator gr = new ReportGenerator();
            Assert.AreEqual(300, gr.TotalYearSalesBySalesman(ano, idVendedor, _session));
        }

    }
}
