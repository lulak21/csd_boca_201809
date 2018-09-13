using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;

namespace SalesSystem.Model
{
    public class Sale
    {
        public virtual int saleId { get; set; }
        public virtual DateTime saleDate { get; set; }
        public virtual int salesmanId { get; set; }
        public virtual double value { get; set; }
    }

}
