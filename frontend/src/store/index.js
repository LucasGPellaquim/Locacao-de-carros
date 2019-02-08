import Vue from "vue";
import Vuex from "vuex";
import formulario from "./modules/formulario";

Vue.use(Vuex);

export default new Vuex.Store({
  modules: {
    formulario
  },
  strict: false,
  plugins: []
});
