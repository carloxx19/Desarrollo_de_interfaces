import "./barraNav.css";
import "./index.css";
import BarraNav from "./barraNav";
import axios from 'axios';
import { useState, useEffect } from 'react';
import Footer from "./footer";

function Favorito() {
    const [personajes, setpersonajes] = useState([]);
    useEffect(() => {
        axios.get("http://localhost:3000/favorito").then(response => {
            setpersonajes(response.data.favorito);
        });
    }, []);

    let listaPersonajes = personajes.data;

    if (personajes != null) {

        listaPersonajes =
            <>
                <div className="Tarjeta">
                    <div className="Favorito">
                        <>
                            <br />
                            <img src={personajes.image}></img>
                            <br />
                            <h3> Nombre: {personajes.name}</h3>
                            <h3> Genero: {personajes.gender}</h3>
                            <h3> Especie: {personajes.species}</h3>
                        </>
                    </div>
                </div>
            </>
    }
    else {
        <h1>no</h1>
    }

    return (
        <>
            <BarraNav />
            <h1>personaje favorito</h1>
            <br></br>
            <div>
                {listaPersonajes}
            </div>
            <br />
            <br />
            <div class="Footer">
                <Footer pie="Carlos rodrigues toledo || react and nodeJS" />
            </div>
        </>
    );
}
export default Favorito;