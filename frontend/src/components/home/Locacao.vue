<template lang="pug">
    #locacao
        h1 Locação de veículos
        label Por favor escolha o arquivo de texto:
        upload
        formulario
        button.btn.btn-primary(@click="enviarObjeto") Enviar

</template>

<script>
import { mapGetters, mapState } from "vuex";
import Upload from "../shared/Upload";
import Formulario from "./Formulario";

export default {
    name: "locacao",
    components: { Upload, Formulario },
    computed: {
        ...mapGetters([
            "objetoArquivo"
        ])
    },
    methods: {
        enviarObjeto(){
            if(this.objetoArquivo.tipoCarro !== "---") {
                this.$store.dispatch('enviarObjetoArquivo', this.objetoArquivo);
            } else {
                console.log("Faça o upload do arquivo primeiro!");
            }
        }
    }
}
</script>

<style scoped>
    #locacao {
        margin-top: 50px;
        text-align: center;
        color: green;
    }
</style>
