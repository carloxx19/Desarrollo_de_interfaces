import "./barraNav.css";
import BarraNav from "./barraNav";
import fondo from "../imagenes/fondo.jpeg"
import Footer from "./footer";

export default function Inicio() {
    return (
        <>
            <BarraNav />

            <div id="contenido">
                <br></br>
                <h1>App Rick and Morty</h1>
                <p></p>
                <img class="Fondo1" src={fondo} />
            </div>

            <div class="Footer">
                <Footer pie="Carlos rodrigues toledo || react and nodeJS" />
            </div>
        </>
    )
}