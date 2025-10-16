import HomePage from "./Pages/HomePage.jsx";
import React from "react";
import ReactDOM from "react-dom/client";
import { HashRouter as Router,Routes, Route} from "react-router-dom";

function App(){
    return(
            <Router>
                <Routes>
                    <Route path="/" element={<HomePage/>}/>
                </Routes>
            </Router>
    );
}

export default App;