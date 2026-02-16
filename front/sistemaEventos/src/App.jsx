import {BrowserRouter,Routes,Route} from "react-router-dom";

import Login from "./pages/Login";
import Cadastro from "./pages/Cadastro";
function App() {

  return (

      <BrowserRouter>
        <Routes>
          <Route path="/login" element={<Login />}></Route>
          <Route path="/cadastro" element={<Cadastro />} ></Route>
        </Routes>
      </BrowserRouter>
  )
}

export default App
