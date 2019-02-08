<template lang="pug">
	#app
		home
</template>

<script>
import Home from "../pages/Home.vue";

export default {
  components: { Home }
};
</script>

<style>
html, body{
	height: 100vh;
	width: 100vw;
	overflow: hidden;
	background-color: #C9C9C9;
	font-size: 14px;
	font-weight: 300;
	text-align: left;
	font-family: 'Open Sans', Helvetica, Arial, sans-serif;
	-webkit-font-smoothing: antialiased;
	-moz-osx-font-smoothing: grayscale;
}
</style>
