import MainService from "./main/service";

const Formulario = {
    enviarObjetoArquivo: objetoArquivo => MainService.post("/enviarObjetoArquivo", objetoArquivo)
};

export default Formulario;
