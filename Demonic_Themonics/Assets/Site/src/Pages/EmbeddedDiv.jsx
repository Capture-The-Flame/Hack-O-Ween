import React from "react";
import ReactDOM from "react-dom/client";
import {useState} from "react";

const EmbeddedDiv = ({activeTheme, onThemeChange, themes}) =>{
    const themeDetails = {
        Default: {
            details:"Hello",
            Divs:{
                
            }
        },
        Light:{
            details:"LIGHT",
            Divs:{

            }
        },
        Scary:{
            details:"AAAAHH",
            Divs:{

            }
        },
        Secret:{
            details:"flame{DO0MI$C0MING}",
            Divs:{

            }
        }
    };
    return(
        <div>
            <p hidden>{themeDetails[activeTheme].details}</p>
        </div>
    )
}

export default EmbeddedDiv;