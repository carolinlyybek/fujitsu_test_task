<template>
    <v-container>    
        <v-row justify="center">
            <Table @getFeedback='getFeedback'  :feedback="feedback" />
        </v-row>
        <v-row justify="center">
            <Form @postFeedback='postFeedback($event)' />
        </v-row>
    </v-container>
</template>

<script>
import Table from '@/components/Table.vue';
import Form from '@/components/Form.vue';
import { postFeedbackAPI } from '@/services/feedbackService.js';
import { getFeedbackAPI } from '@/services/feedbackService.js'

export default {
    layout: 'default',
    components: {
        Table, 
        Form,
    },
    data() {
        return {
            feedback: []
        }
    }, 
    methods: {
        postFeedback(data) {
            postFeedbackAPI(data)
            .then(this.getFeedback())
            .then(this.getFeedback())
        },
        getFeedback() {
            getFeedbackAPI().then(response =>
                this.feedback = response)
        }
    },
    mounted () {
        this.getFeedback()
    }
    
}
</script>