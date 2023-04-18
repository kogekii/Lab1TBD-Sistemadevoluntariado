

<template>
  <div :class="$estilo.container">
    <div :class="$estilo.login">
      <div :class="$estilo.loginrow1">
        <h1>Login</h1>
      </div>
      <div :class="$estilo.loginrow2">
        <label>Username</label>
        <input />
        <label>Password</label>
        <input type="password"/>
      </div>
      <div :class="$estilo.loginrow3">
        <button>enviar</button>
        <a>registrarse</a>
      </div>
    </div>
  </div>
</template>




<script>
import estilo from './App.module.css';
export default {
  data() {
    return {
      $estilo: estilo,
    }
  }
}
</script>

<style module>
body {
  margin: 0;
}
</style>