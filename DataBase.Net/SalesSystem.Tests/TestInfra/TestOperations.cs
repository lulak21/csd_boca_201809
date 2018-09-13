using System.Data;
using System.Data.SqlClient;
using NDbUnit.Core.SqlClient;
using NDbUnit.Core;

namespace SalesSystem
{
    public static class TestOperations
    {
        public static void LoadDataBase(
            string schema,
            string data)
        {
            var dataBase = getDataBase();
            dataBase.ReadXmlSchema(schema);
            dataBase.ReadXml(data);
            dataBase.PerformDbOperation(DbOperationFlag.CleanInsertIdentity);
        }

        private static INDbUnitTest getDataBase()
        {
            var dataBase = new SqlDbUnitTest(TestConfiguration.ConnectionString);
            return dataBase;
        }

    }
}
