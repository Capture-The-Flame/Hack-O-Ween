import React from "react";
import ReactDOM from "react-dom/client";
import {useState} from "react";
import "./ThemeOptions.css";

const ThemeOptions = ({activeTheme, onThemeChange, themes}) =>{

    const themeNames = {
        Default: 'Default',
        Light: 'Light',
        Scary: 'Scary'
    }

    return(
        <div>
            <ul className="ThemeOptions">
                {themes.map(themeKey=> (
                    <li
                        key={themeKey}
                        className={`themeButton ${activeTheme === themeKey ? 'active' : ''}`}
                        onClick={()=>onThemeChange(themeKey)}
                        >
                            {themeNames[themeKey] || themeKey}
                    </li>
                ))}
            </ul>
        </div>
    )
}

export default ThemeOptions;