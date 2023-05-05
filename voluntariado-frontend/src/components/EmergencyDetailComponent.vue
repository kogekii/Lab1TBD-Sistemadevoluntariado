<template>
    <div>
        <h1>Emergencia : {{ $route.params.id }}</h1>
        <table>
            <thead>
                <tr>
                    <th>Id</th>
                    <th>Nombre</th>
                    <th>Descripción</th>
                    <th>Cantidad de voluntarios requeridos</th>
                    <th>Cantidad de voluntarios inscritos</th>
                    <th>Id de emergencia</th>
                    <th>Fecha de inicio</th>
                    <th>Fecha de fin</th>
                    <th>Id de estado</th>
                </tr>
            </thead>
            <tbody>
                <tr v-for="tarea in emergency" :key="tarea.id">
                    <td>{{ tarea.id }}</td>
                    <td>{{ tarea.nombre }}</td>
                    <td>{{ tarea.descrip }}</td>
                    <td>{{ tarea.cant_vol_requeridos }}</td>
                    <td>{{ tarea.catn_vol_inscritos }}</td>
                    <td>{{ tarea.id_emergencia }}</td>
                    <td>{{ tarea.finicio }}</td>
                    <td>{{ tarea.ffin }}</td>
                    <td>{{ tarea.id_estado }}</td>
                    <td><Router-link :to="{path: '/tarea/' + tarea.id}"  style="color:black">GO</Router-link></td>
                </tr>
            </tbody>
        </table>
    </div>
</template>

<script>
export default {
    name: 'Emergencia',
    data() {
        return {
            emergency: [],
            voluntarioRanking: []

        };
    },
    mounted() {
        this.fetchUsers();
    },
    methods: {
        async fetchUsers() {
            const response = await fetch('http://localhost:8080/tarea/byemergencia/' + this.$route.params.id);
            const data = await response.json();
            this.emergency = data;
        }
    }
}
</script>
