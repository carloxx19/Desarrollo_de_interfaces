import './App.css';
import Inicio from './componentes/inicio';
import Personajes from './componentes/personajes';
import { BrowserRouter, Route, Routes } from 'react-router-dom';
import Favorito from './componentes/favorito';
import Error404 from './componentes/error404';



function App() {
  return (
    <>
      <BrowserRouter>
        <Routes>
          <Route path='/' element={<Inicio />}></Route>
          <Route path='/personajes' element={<Personajes />}></Route>
          <Route path='/favorito' element={<Favorito />}></Route>
          <Route path='*' element={<Error404/>}></Route>
        </Routes>
      </BrowserRouter>

    </>
  );
}

export default App;