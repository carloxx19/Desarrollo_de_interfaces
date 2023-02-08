import "./barraNav.css";
import { Button } from "react-bootstrap";
import 'bootstrap/dist/css/bootstrap.min.css';


export default function BarraNav() {
    let buttons = (
        <div id="barra">
            <Button href="/" className="ms-2 mt-3 btn-md" variant="light" class="btn btn-outline-light" >Inicio</Button>
            <Button href="/personajes" className="ms-2 mt-3 btn-md" variant="light" class="btn btn-outline-light">Personajes</Button>
            <Button href="/favorito" className="ms-2 mt-3 btn-md" variant="light" class="btn btn-outline-light">Favorito</Button>
        </div>
    )

    return (
        <header>
            <nav>
                <ul>
                    {buttons}
                </ul>
            </nav>
        </header>
    );
}

