import { useEffect, useState } from 'react'
import './App.css'
import ProductList from './ProductList';

function App() {
  const [products, setProducts] = useState([]);

  //Below is Useeffect hook where we are making use of Javascript fetch 
  //to do an API call to our Backend, and we are getting the response in
  //json and then we are setting this json to the product state

  useEffect(() => {
    fetch('http://localhost:8080/api/products')
      .then(response => response.json())
      .then(data => setProducts(data));
  }, []);
  return (
    // {/* To display the data on the frontend */}
    <div className='container'>
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
