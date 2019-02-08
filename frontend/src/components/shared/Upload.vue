<template lang="pug">
    #upload
        input(type="file" accept='text/plain' @change="verificarArquivo")
</template>

<script>
export default {
    name: "upload",
    data() {
        return {
            meses: [ 'Jan', 'Fev', 'Mar', 'Abr', 'Mai', 'Jun', 'Jul', 'Ago', 'Set', 'Out', 'Nov', 'Dez' ]
        }
    },
    methods: {
        verificarArquivo(event){
            const file = event.target.files[0];
            const reader = new FileReader();

            reader.onload = e => this.formatarTextoArquivo(e.target.result);
            reader.readAsText(file);
        },
        formatarTextoArquivo(textoArquivo) {
            let indiceTipoCarro = textoArquivo.indexOf(":");
            let indiceQuantidadePassageiros = parseInt(textoArquivo.indexOf(":", indiceTipoCarro + 1));
            let intervaloDatas = textoArquivo.substring(indiceQuantidadePassageiros + 1);
            this.formatarDatas(intervaloDatas);

            let textoFormatado = {
                tipoCarro: textoArquivo.substring(0, indiceTipoCarro),
                quantidadePassageiros: textoArquivo.substring(indiceTipoCarro + 1, indiceQuantidadePassageiros),
                intervaloData: this.formatarDatas(intervaloDatas)
            };

            this.$store.dispatch('armazenarTextoArquivo', textoFormatado);
        },
        formatarDatas(intervaloDatas) {
            let primeiraData = new Date(intervaloDatas.substring(5, 9), 
                this.meses.indexOf(intervaloDatas.substring(2, 5)) + 1, 
                intervaloDatas.substring(0, 2));
            
            let indiceUltimaVirgula = intervaloDatas.lastIndexOf(",");
            
            let ultimaData = new Date(intervaloDatas.substring(indiceUltimaVirgula + 7, indiceUltimaVirgula + 11), 
                this.meses.indexOf(intervaloDatas.substring(indiceUltimaVirgula + 4, indiceUltimaVirgula + 7)) + 1, 
                intervaloDatas.substring(indiceUltimaVirgula + 2, indiceUltimaVirgula + 4));

            return [ primeiraData, ultimaData ];
        }

    }
}
</script>

<style scoped>
    #upload {
        margin-top: 20px;
    }
</style>
