import React from "react";
import ReactDOM from "react-dom/client";
import Backdrop from "./Photos/backdrop.jpg";
import "./HomePage.css";

function HomePage(){
    return(
        <div className="completeDiv">
            <img src={Backdrop} className="backdrop"/>

            <div className="mainDiv">
                <p>Hello</p>
            </div>
        </div>
    )
}

export default HomePage;