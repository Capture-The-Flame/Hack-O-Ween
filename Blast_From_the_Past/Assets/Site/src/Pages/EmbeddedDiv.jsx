import React from "react";
import ReactDOM from "react-dom/client";
import {useState} from "react";

const EmbeddedDiv = ({activeTheme, onThemeChange, themes}) =>{
    const themeDetails = {
        Default: {
            details:"Hello"
        },
        Light:{
            details:"LIGHT"
        },
        Scary:{
            details:"AAAAHH"
        },
        Secret:{
            details:"flame{DO0MI$C0MING}"
        }
    };
    return(
        <div>
            <p>{themeDetails[activeTheme].details}</p>
        </div>
    )
}

export default EmbeddedDiv;