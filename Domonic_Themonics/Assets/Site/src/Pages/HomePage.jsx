import React from "react";
import ReactDOM from "react-dom/client";
import Backdrop from "./Photos/backdrop.png";
import "./HomePage.css";
import {useState} from "react";
import EmbeddedDiv from "./EmbeddedDiv";
import ThemeOptions from "./ThemeOptions";

function HomePage(){
    const [theme,setTheme]=useState('Default');

    const themes = {
        Default:"",
        Light:"",
        Scary:""
    }

    return(
        <div className="completeDiv">
            <img src={Backdrop} className="backdrop"/>

            <div className="mainDiv">
                <ThemeOptions   
                    activeTheme={theme}
                    onThemeChange={setTheme}
                    themes={Object.keys(themes)}
                />
                <EmbeddedDiv    
                    activeTheme={theme}
                    onThemeChange={setTheme}
                    themes={themes}
                />

            </div>
        </div>
    )
}

export default HomePage;