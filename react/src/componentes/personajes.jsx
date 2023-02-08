import "./barraNav.css";
import "./index.css";
import BarraNav from "./barraNav";
import axios from 'axios';
import { useState, useEffect } from 'react';
import { Button } from 'react-bootstrap';
import Footer from "./footer";
import { useNavigate } from "react-router-dom";

function Personajes() {

    const navigate = useNavigate();

    const [personajes, setpersonajes] = useState([]);
    useEffect(() => {
        axios.get("http://localhost:3000/personajes").then(response => {
            setpersonajes(response.data.personajes);
        });
    }, []);

    let listaPersonajes = <h1>No se encontraron personajes.</h1>;

    if (personajes.length > 0) {

        listaPersonajes = personajes.map(dato => (
            <div class="Fila">
                <div class="Columna">
                    <div className="Tarjeta">
                        <div className="Contenido">
                            <>
                                <br></br>
                                <img src={dato.image}></img>
                                <br></br>
                                <h3>Nombre: {dato.name}</h3>
                                <h3>Genero: {dato.gender}</h3>
                                <h3>Especie: {dato.species}</h3>
                                <Button className="boton" onClick={() => {
                                    navigate('/');
                                    window.location.href = `http://localhost:3000/eliminar/${dato._id}`;
                                }}>Eliminar</Button>
                                <br></br>
                            </>
                        </div>
                    </div>
                </div>
            </div>
        ));
    }
    return (
        <>
            <BarraNav />
            <br></br>
            <div id="contenido2">
                <h2>Lista de Personajes.</h2>
                <br></br>
                {listaPersonajes}
            </div>
            <div class="Footer">
                <Footer pie="Carlos rodrigues toledo || react and nodeJS" />
            </div>
        </>
    );
}
export default Personajes;