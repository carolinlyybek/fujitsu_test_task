<template>
    <div>
        <v-data-table
        :headers="headers"
        :items="feedback"
        :items-per-page=Number.MAX_VALUE
        hide-default-footer
        ></v-data-table>
    </div>
</template>

<script>

    export default {
        data() {
            return{
                headers: [
                    {
                        text: '#',
                        value: 'id',
                        align: 'start',
                        sortable: false
                    },
                    {text: 'Name', value: 'name', sortable: false,},
                    {text: 'Email', value: 'email', sortable: false,},
                    {text: 'Category', value: 'category', sortable: false,},
                    {text: 'Text', value: 'text', sortable: false,},
                ]
            }
        },
        props: {
            feedback: Array
        },
        mounted() {
            this.$emit('getFeedback')
        }
    }
</script>

<style lang="css" scoped>
div {
    width: 100% ;
    justify-content: center;
    margin-top: 10px;
}
</style>