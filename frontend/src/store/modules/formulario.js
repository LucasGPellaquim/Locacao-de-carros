import Formulario from "../../services/formulario";

export const state = {
  objetoArquivo: {
    tipoCarro:  '---',
    quantidadePassageiros:  0,
    intervaloData:  [ 
        new Date(), 
        new Date() 
    ]
  },
  carroEscolhido: ''
};

export const getters = {
  objetoArquivo: state => state.objetoArquivo,
  carroEscolhido: state => state.carroEscolhido
};

export const actions = {
  
  enviarObjetoArquivo: ({ commit }, objetoArquivo) => {

    Formulario.enviarObjetoArquivo(objetoArquivo)
      .then( ({ carroEscolhido }) => {
        commit('resposta_success', carroEscolhido);
      })
      .catch(() => {
        commit('resposta_error');
      })
  },

  armazenarTextoArquivo: ({ commit }, textoArquivo) => {
    commit('armazenar_texto_arquivo', textoArquivo);
  }
}

export const mutations = {
  armazenar_texto_arquivo: (state, textoArquivo) => (state.objetoArquivo = textoArquivo),

  resposta_success: (state, carroEscolhido) => (state.carroEscolhido = carroEscolhido),

  resposta_error: (state) => (state.carroEscolhido = 'Erro ao verificar melhor carro!')
};

export default {
  state,

  getters,

  actions,

  mutations
};
