import { useEffect, useState } from 'react'
import './App.css'
import ProductList from './ProductList';

function App() {
  const [products, setProducts] = useState([]);
  const [categories, setCategories] = useState([]);

  const [selected, setSelectedCategory] = useState(null);
  const [searchTerm, setSearchTerm] = useState("");
  const [sortOrder, setSortOrder] = useState("asc");

  //Below is Useeffect hook where we are making use of Javascript fetch 
  //to do an API call to our Backend, and we are getting the response in
  //json and then we are setting this json to the product state

  useEffect(() => {
    // Before we were making only one API Call
    fetch('http://localhost:8080/api/products')
      .then(response => response.json())
      .then(data => setProducts(data));
      
      // But now we will be making two API Calls
      // One to fetch the profucts(above) and other to 
      // fetch the categories(below)

    fetch('http://localhost:8080/api/categories')
      .then(response => response.json())
      .then(data => setCategories(data));      
  }, []);

const handleSearchChange = (event) => {
  setSearchTerm(event.target.value);
};

const handleSortChange = (event) => {
  setSortOrder(event.target.value);
};

  return (
    // {/* To display the data on the frontend */}
    <div className='container'>
      <h1 className='my-4'>
        {/* UI for Filter */}
        Product Catalog
      </h1>

      <div className='row align-items-center mb-4'>
        {/* div for Functionality for filter searching in sorting */}
        <div className='col-md-3 col-sm-12 mb-2'>
          {/* div for category filter */}
          <p>Category Filter</p>
        </div>

        <div className='col-md-5 col-sm-12 mb-2'>
          <input type = 'text' className='form-control'
                 placeholder='Search for products'
                 onChange={handleSearchChange} 
                 />

        </div>

        <div className='col-md-4 col-sm-12 mb-2'>
          <select className='form-control' onChange={handleSortChange}>
            <option vlaue="asc">Sort by Price: Low to High</option>
            <option vlaue="desc">Sort by Price: High to Low</option>

          </select>
        </div>
      </div>

      <div>
        {products.length ? (
          //Display Products
          <ProductList products={products}/>
        ) : (
          <p>No Products Found</p>
        )}
      </div>
  

    </div>
  )
}

export default App
