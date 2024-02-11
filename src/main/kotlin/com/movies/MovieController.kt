package com.movies

import jakarta.ws.rs.*
import jakarta.ws.rs.core.MediaType
import jakarta.ws.rs.core.Response
import org.eclipse.microprofile.openapi.annotations.Operation
import org.eclipse.microprofile.openapi.annotations.media.Content
import org.eclipse.microprofile.openapi.annotations.media.Schema
import org.eclipse.microprofile.openapi.annotations.parameters.RequestBody
import org.eclipse.microprofile.openapi.annotations.responses.APIResponse

@Path("/movies")
class MovieController {

    private var movies = ArrayList<Movie>()

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @Operation(
        operationId = "getMovies",
        description = "Get all movies inside the list"
    )
    @APIResponse(
        responseCode = "200",
        description = "Operation completed",
        content = [Content(mediaType = MediaType.APPLICATION_JSON)]
    )
    fun getMovies(): Response {
        return Response.ok(movies).build()
    }

    @GET
    @Produces(MediaType.TEXT_PLAIN)
    @Path("/size")
    fun countMovies(): Int {
        return movies.size
    }

    @POST
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    @Operation(
        operationId = "createMovie",
        summary = "Create a new Movie",
        description = "Create a new movie to add inside  the list"
    )
    @APIResponse(
        responseCode = "201",
        description = "Movie Created",
        content = [Content(schema = Schema(implementation = Movie::class))]
    )
    fun createMovie(
        @RequestBody(
            description = "Movie to create",
            required = true,
            content = [Content(mediaType = MediaType.APPLICATION_JSON)]
        )
        newMovie: Movie
    ): Response {
        movies.add(newMovie)
        return Response.status(Response.Status.CREATED).entity(movies).build()
    }

    @PUT
    @Path("{id}/{title}")
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    fun updateMovie(
        @PathParam("id") id: Long,
        @PathParam("title") title: String,
    ): Response {
        movies.first { it.id == id }.title = title
        return Response.ok(movies).build()
    }

    @DELETE
    @Path("{id}")
    @Consumes(MediaType.APPLICATION_JSON)
    @APIResponse(
        responseCode = "204",
        description = "Movie Deleted",
        content = [Content(mediaType = MediaType.APPLICATION_JSON)]
    )
    @APIResponse(
        responseCode = "400",
        description = "Movie not valid",
        content = [Content(mediaType = MediaType.APPLICATION_JSON)]
    )
    fun deleteMovie(@PathParam("id") id: Long): Response {
        val removed = movies.removeIf { it.id == id }
        return if (removed) Response.noContent().build() else Response.status(Response.Status.BAD_REQUEST).build()
    }

}