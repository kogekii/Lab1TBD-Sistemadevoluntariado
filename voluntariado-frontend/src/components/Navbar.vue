<template>
    <nav>
        <ul>
            <li><a href="/">Inicio</a></li>
            <li><a href="/emergencias">Emergencias</a></li>
            <li><a href="/contacto">Contacto</a></li>
        </ul>
    </nav>
</template>
  
<script>
export default {
    name: 'Navbar',
}
</script>
  
<style>
nav {
    background-color: #333;
    color: white;
}

ul {
    display: flex;
    justify-content: space-between;
    list-style-type: none;
    margin: 0;
    padding: 10px;
}

li {
    margin: 0 10px;
}

a {
    color: white;
    text-decoration: none;
}
</style>
  