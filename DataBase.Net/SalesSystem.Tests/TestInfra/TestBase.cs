using NUnit.Framework;

namespace SalesSystem
{       
    public abstract class TesteBase 
    {
        [SetUp]
        public virtual void TestInitialize() 
        {
            TestOperations.LoadDataBase(TestConfiguration.Scheme, TestConfiguration.TestData);
        }
    }
}