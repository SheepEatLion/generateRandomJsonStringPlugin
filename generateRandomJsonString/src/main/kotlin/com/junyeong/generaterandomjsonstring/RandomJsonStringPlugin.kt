package com.junyeong.generaterandomjsonstring

import com.intellij.openapi.actionSystem.AnAction
import com.intellij.openapi.actionSystem.AnActionEvent
import com.intellij.openapi.project.Project
import com.intellij.openapi.ui.Messages

class RandomJsonStringPlugin: AnAction() {
    companion object {
        const val DEFAULT_CONSTRAINT = "D"
        const val DEFAULT_LENGTH = "6"
    }

    override fun actionPerformed(event: AnActionEvent) {
        val project: Project? = event.project
        val input = Messages.showInputDialog(project, "Enter variable names(keys) separated by comma:", "Generate JSON-STRING", Messages.getQuestionIcon()) ?: ""

        if (input.isEmpty()) return Messages.showMessageDialog(project, "", "DONE", Messages.getInformationIcon())

        Messages.showMessageDialog(project, generateJsonString(input), "DONE", Messages.getInformationIcon())
    }

    private fun generateJsonString(input: String): String{
        val map = linkedMapOf<String, String>()
        input.split(",").map { key ->
            if (key.contains("*")) {
                val keyWithConstraint = key.split("*")
                map[keyWithConstraint[0]] = findConstraint(keyWithConstraint[1])
            }
            else {
                map[key] = generateValue()
            }
        }

        return mapToJsonStringLiteral(map)
    }

    private fun mapToJsonStringLiteral(map: Map<String, String>): String {
        val jsonString = map.entries.joinToString(prefix = "{", postfix = "}") { (key, value) ->
            "\"$key\": \"$value\""
        }
        return jsonString.replace("\"", "\\\"")
    }

    private fun findConstraint(constraint: String): String {
        val regex = Regex("^([an]?)(\\d{1,2})?$")
        val matchResult = regex.find(constraint) ?: return generateValue()


        val alphaNumPart = matchResult.groupValues.getOrElse(1) { DEFAULT_CONSTRAINT }
        val lengthPart = matchResult.groupValues.getOrElse(2) { DEFAULT_LENGTH }
        return generateValue(length = lengthPart, constraint = alphaNumPart)
    }

    private fun generateValue(length: String = DEFAULT_LENGTH, constraint: String = DEFAULT_CONSTRAINT): String {
        val charset = getCharset(constraint)
        return (1..length.toInt())
                .map { charset.random() }
                .joinToString("")
    }

    private fun getCharset(constraint: String): List<Char> {
        return when (constraint) {
            "a" -> ('a'..'z') + ('A'..'Z')
            "n" -> ('0'..'9').flatMap { it.toString().toList() }
            else -> ('a'..'z') + ('A'..'Z') + ('0'..'9')
        }
    }
}