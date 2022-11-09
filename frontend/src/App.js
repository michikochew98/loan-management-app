import './App.css';
import Navbar from './component/navbar/Navbar';
import Sidebar from './component/sidebar/Sidebar';
import Home from './pages/home/Home';
import {
  createBrowserRouter,
  RouterProvider,
} from "react-router-dom";
import UserList from './pages/userList/UserList';
import User from './pages/user/User';
import NewUser from './pages/newUser/NewUser';

const router = createBrowserRouter([
  {
    path: "/",
    element: <Home />,
    // children: [
    //   {
    //     path: "users",
    //     element: <UserList />,
    //   },
    // ],
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
]);

function App() {
  return (
    <div className='App'>
      <Navbar />
      <div className='container'>
        <Sidebar />
        <RouterProvider
          router={router}
          //fallbackElement={<BigSpinner />}
        />
      </div>
    </div>
  );
}

export default App;
