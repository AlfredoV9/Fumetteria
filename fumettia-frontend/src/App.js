import { useEffect } from "react";
import Routering from "./utility/Routering";
import 'bootstrap/dist/css/bootstrap.min.css';
import 'bootstrap/dist/js/bootstrap.bundle.min.js';

function App() {
  useEffect(() => {
    document.title = "Fumetteria";
  }, []);

  return <Routering />;
}

export default App;