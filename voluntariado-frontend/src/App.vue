<template>
  <div id="app">
    <Navbar />
    <RouterView />
  </div>
</template>

<script>
import Navbar from './components/Navbar.vue';

export default {
  components: {
    Navbar,
  },
};
</script>

<style module>
  body {
    margin: 0;
  }
</style>
