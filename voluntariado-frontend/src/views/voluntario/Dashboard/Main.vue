<template>
    <div>
        <Appbar />
        <router-view />
    </div>
</template>

<script>
import Appbar from '@/components/Appbar.vue';

export default {
    name: "VoluntarioProfileView",
    components: {
        Appbar,
    }
}
</script>

<style scoped>

</style>