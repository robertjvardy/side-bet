import { useState } from "react";
import "./App.css";
import axios from "axios";
import { Route, Routes } from "react-router-dom";
import Authentication from "./scenes/Authentication";
import ErrorPage from "./scenes/Error/ErrorPage";
import { http } from "./setUp";

const RootRouter = () => {
  return (
    <Routes>
      <Route path="/auth" Component={Authentication} />
      <Route path="/error" Component={ErrorPage} />
      <Route path="/home" />
      {/* <Route path="*" Component={() => <Redirect to="/dashboard" />} /> */}
    </Routes>
  );
};

function App() {
  const [isAuthenticated, setIsAuthenticated] = useState(false);
  const test = async () => {
    const response = await http.post("/auth/login", {
      username: "db_user",
      password: "123",
    });
    console.log(response.data);
  };

  return (
    <>
      <h1>Side Bet</h1>
      <div className="card">
        <button onClick={() => test()}>Login</button>
      </div>
      <RootRouter />
    </>
  );
}

export default App;
