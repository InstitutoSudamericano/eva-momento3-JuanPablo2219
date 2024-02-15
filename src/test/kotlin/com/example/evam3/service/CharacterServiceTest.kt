package com.example.evam3.service

import com.example.evam3.entity.Character
import com.example.evam3.entity.Scene
import com.example.evam3.repository.CharacterRepository
import com.example.evam3.repository.SceneRepository
import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.Test
import org.mockito.InjectMocks
import org.mockito.Mock
import org.mockito.Mockito
import org.mockito.MockitoAnnotations
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.web.server.ResponseStatusException
import java.util.*

@SpringBootTest
class CharacterServiceTest {

    @InjectMocks
    lateinit var characterService: CharacterService

    @Mock
    lateinit var characterRepository: CharacterRepository

    @Mock
    lateinit var sceneRepository: SceneRepository

    @Test
    fun saveCharacter_Success() {
        MockitoAnnotations.openMocks(this)

        val sceneId = 1L

        val character = Character().apply {
            id = 1L
            name = "John"
            cost = 100.0
            stock = 5
            this.sceneId = sceneId
        }

        val sceneMock = Scene().apply {
            id = sceneId
            description = "Description"
            budget = 500.0
            minutes = 120
            filmId = 1L
        }

        Mockito.`when`(sceneRepository.findById(sceneId)).thenReturn(Optional.of(sceneMock))
        Mockito.`when`(characterRepository.findBySceneId(sceneId)).thenReturn(emptyList())
        Mockito.`when`(characterRepository.save(Mockito.any(Character::class.java))).thenReturn(character)

        val savedCharacter = characterService.save(character)

        Assertions.assertEquals(character, savedCharacter)
    }

    @Test
    fun saveCharacter_Failed_BudgetExceeded() {
        MockitoAnnotations.openMocks(this)

        val sceneId = 1L

        val character = Character().apply {
            id = 1L
            name = "John"
            cost = 600.0
            stock = 5
            this.sceneId = sceneId
        }

        val sceneMock = Scene().apply {
            id = sceneId
            description = "Description"
            budget = 500.0
            minutes = 120
            filmId = 1L
        }

        Mockito.`when`(sceneRepository.findById(sceneId)).thenReturn(Optional.of(sceneMock))
        Mockito.`when`(characterRepository.findBySceneId(sceneId)).thenReturn(emptyList())

        Assertions.assertThrows(ResponseStatusException::class.java) {
            characterService.save(character)
        }
    }
}
