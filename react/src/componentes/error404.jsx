import { useNavigate } from "react-router-dom";
import BarraNav from "./barraNav";
import "./error404.css";

const Error404 = () => {
    const navigate = useNavigate()
    return (
        <>
            <BarraNav/>
            <div className="Error">
                <h1>NOT FOUND
                    <br />404
                    <br/> PAGE NOT FOUND
                </h1>
            </div>
        </>
    );
}
export default Error404