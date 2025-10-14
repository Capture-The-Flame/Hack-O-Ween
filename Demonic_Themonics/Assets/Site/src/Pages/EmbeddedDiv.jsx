import React, { createElement } from "react";
import ReactDOM from "react-dom/client";
import {useState, useEffect} from "react";

const EmbeddedDiv = ({activeTheme, onThemeChange, themes}) =>{
    
    async function make_divs() {
        const temp = document.querySelector(".bigDiv");
        if(temp!=null)
            document.querySelectorAll(".bigDiv").forEach(e => e.remove());

        const parent = document.createElement("div");
        parent.setAttribute("class","bigDiv");
        parent.setAttribute("hidden","");

        const length = themeDetails[activeTheme].Divs.length;
        for(let j = 0; j<length-1;j++){
            for(let i=0;i<1000;i++){
                const div = document.createElement("div");
                const p = document.createElement("p");
                if(i>600 && i<900 && activeTheme=="Scary"){
                    if(i==746){
                        p.textContent="flame{D00MI$C0MING}";
                        p.setAttribute("class","flag");
                        p.setAttribute("id","flag");
                    }
                    else if (i%10!=0){
                        p.textContent=themeDetails[activeTheme].Divs[j].details;
                        p.setAttribute("class","flag");
                    }
                    else{
                        p.textContent=themeDetails[activeTheme].Divs[j].details;
                        p.setAttribute("id","flag");
                    }
                }
                else
                    p.textContent=themeDetails[activeTheme].Divs[j].details;
                div.appendChild(p);
                parent.appendChild(div);
            }
        }
        const main = document.querySelector(".mainDiv");
        main.appendChild(parent);
    };

    const themeDetails = {
        Default: {
            details:"Hello",
            Divs:[
                {details:"fl"},
                {details:"hell0"}
            ]
        },
        Light:{
            details:"LIGHT",
            Divs:[
                {details:"fl"},
                {details:"hell0"}
            ]
        },
        Scary:{
            details:"AAAAHH",
            Divs:[
                {details:"fl"},
                {details:"hell0"}
            ]
        },
        Secret:{
            details:"NOOOO",
            Divs:[
                {details:"fl"},
                {details:"hell0"}
            ]
        }
    };

     useEffect(() => {
        make_divs();
    }, [activeTheme]);

    return(
        <div id="BOOOOOOO">
            <p hidden>{themeDetails[activeTheme].details}</p>
        </div>
    )
}

export default EmbeddedDiv;