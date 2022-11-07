import Navbar from "./component/navbar/Navbar";
import Sidebar from "./component/sidebar/Sidebar";
import "./App.css";
import Home from "./pages/home/Home";

function App() {
  return (
    <div className="App">
      <Navbar />
      <div className="container">
        <Sidebar />
        <Home />
      </div>
    </div>
  );
}

export default App;
