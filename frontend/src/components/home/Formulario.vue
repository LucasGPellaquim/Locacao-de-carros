<template lang="pug">
    #formulario
        .input-group.mb-3
            .input-group-prepend
                span.input-group-text Tipo de carro:
            input.form-control(type="text" :value="objetoArquivo.tipoCarro" readonly)
        .input-group.mb-3
            .input-group-prepend
                span.input-group-text Quantidade de passageiros:
            input.form-control(type="text" :value="objetoArquivo.quantidadePassageiros" readonly)
        .input-group.mb-3
            .input-group-prepend
                span.input-group-text De:
            input.form-control(type="text" :value="formatarData(objetoArquivo.intervaloData[0])" readonly)
            .input-group-prepend
                span.input-group-text Até
            input.form-control(type="text" :value="formatarData(objetoArquivo.intervaloData[1])" readonly)


</template>

<script>
import { mapGetters} from "vuex";

export default {
    name: "formulario",
    computed: {
        ...mapGetters([
            "objetoArquivo"
        ])
    },
    methods: {
        formatarData(data) {
            return data.getDate() + "/" + (data.getMonth() + 1) + "/" + data.getFullYear();
        }
    }
}
</script>

<style scoped>
    #formulario {
        margin: 50px;
        text-align: center;
        color: green;
    }
</style>
