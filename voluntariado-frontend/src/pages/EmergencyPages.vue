<template>
    <div>
        <table>
            <thead>
                <tr>
                    <th>ID</th>
                    <th>Name</th>
                    <th>Descrip</th>
                    <th>Finicio</th>
                    <th>Ffin</th>
                    <th>id institucion</th>
                </tr>
            </thead>
            <tbody>
                <tr v-for="(emergency, index) in emergency" :key="index">
                    <td>{{ emergency.id }}</td>
                    <td>{{ emergency.nombre }}</td>
                    <td>{{ emergency.descrip }}</td>
                    <td>{{ emergency.finicio }}</td>
                    <td>{{ emergency.ffin }}</td>
                    <td>{{ emergency.id_institucion }}</td>
                    <td><Router-link :to="{path: '/emergencias/' + emergency.id}" style="color:black">GO</Router-link></td>

                </tr>
            </tbody>
        </table>
    </div>
</template>
  
<script>
export default {
    name: 'EmergencyPages',
    data() {
        return {
            emergency: []

        };
    },
    mounted() {
        this.fetchUsers();
    },
    methods: {
        async fetchUsers() {
            const response = await fetch('http://localhost:8080/emergencia');
            const data = await response.json();
            this.emergency = data;
        }
    }
};
</script>
  