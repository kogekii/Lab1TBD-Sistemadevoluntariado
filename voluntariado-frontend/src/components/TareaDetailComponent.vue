<template>
    <h1>hola: {{$route.params.id}}</h1>
    <table>
    <thead>
      <tr>
        <th>ID</th>
        <th>ID Voluntario</th>
        <th>ID Tarea</th>
        <th>Puntaje</th>
        <th>Invitado</th>
        <th>Participa</th>
      </tr>
    </thead>
    <tbody>
      <tr v-for="ranking in voluntarioRanking" :key="ranking.id">
        <td>{{ ranking.id }}</td>
        <td>{{ ranking.id_voluntario }}</td>
        <td>{{ ranking.id_tarea }}</td>
        <td>{{ ranking.puntaje }}</td>
        <td>{{ ranking.flg_invitado }}</td>
        <td>{{ ranking.flg_participa }}</td>
      </tr>
    </tbody>
  </table>
</template>

<script>
export default {
    name: 'Tarea',
    data() {
        return {
            voluntarioRanking: []
        };
    },
    mounted() {
        this.fetchUsers();
    },
    methods: {
        async fetchUsers() {
            const response = await fetch('http://localhost:8080/ranking/bytarea/' + this.$route.params.id);
            const data = await response.json();
            this.voluntarioRanking = data;
        }
    }
}
</script>