<template lang="pug">
    #home       
        h1 Bem-vindo a avaliação para Desenvolvedor Java!
        locacao
</template>

<script>
import Locacao from "../components/home/Locacao";

export default {
    name: "home",
    components: { Locacao }
}
</script>

<style scoped>
    #home {
        margin: 50px;
        color: #424242;
        justify-content: center;
        align-items: center;
        text-align: center;
    }
    
</style>
