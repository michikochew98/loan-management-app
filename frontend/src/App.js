import './App.css';
import Navbar from './component/navbar/Navbar';
import Sidebar from './component/sidebar/Sidebar';
import Home from './pages/home/Home';
import {
  createBrowserRouter,
  Outlet,
  RouterProvider,
} from "react-router-dom";
import UserList from './pages/userList/UserList';
import User from './pages/user/User';
import NewUser from './pages/newUser/NewUser';
import ProductList from './pages/productList/ProductList';
import Product from './pages/product/Product';
import NewProduct from './pages/newProduct/NewProduct';

const NavbarWrapper = () => {
  return (
    <div className='App'>
      <Navbar />
      <div className='container'>
        <Sidebar />
        <Outlet />
      </div>
    </div>
  )
};


const router = createBrowserRouter([
  {
    path: "/",
    element: <NavbarWrapper />,
    children: [
      {
        path: "/",
        element: <Home />,
      },
      {
        path: "/users",
        element: <UserList />,
      },
      {
        path: "/user/:userId",
        element: <User />,
      },
      {
        path: "/newUser",
        element: <NewUser />,
      },
      {
        path: "/products",
        element: <ProductList />,
      },
      {
        path: "/product/:productId",
        element: <Product />,
      },
      {
        path: "/newProduct",
        element: <NewProduct />,
      },
    ],
  },
]);

function App() {
  return (

    <RouterProvider
      router={router}
    //fallbackElement={<BigSpinner />}
    />

  );
}

export default App;
