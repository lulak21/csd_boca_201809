using System.IO;

namespace SalesSystem
{
    public class TestConfiguration
    {
        public static string DataPath;
        public static string BackupData;
        public static string TestData;
        public static string Scheme;
        public static string ConnectionString;

        public static void SetupTestVariables(
            string basedir,
            string connectionString)
        {
            ConnectionString = connectionString;
            DataPath = Path.Combine(basedir, @"Scenarios\");
            BackupData = Path.Combine(DataPath, "BackupData.xml");
            TestData = Path.Combine(DataPath, "Data.xml");
            Scheme = Path.Combine(DataPath, "Schema.xsd");
        }
    }
}
