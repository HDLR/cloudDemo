export default {
  namespaced: true,
  state: {
    //群人数
    sumCount: 0
  },
  mutations: {
    updateSumCount (state, sumCount) {
      state.sumCount = sumCount
    }
  }
}
