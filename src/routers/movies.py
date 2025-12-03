from fastapi import APIRouter, Depends, HTTPException
from sqlmodel import Session, select
from app.models import Movie
from app.schemas import MovieCreate, MovieUpdate
from app.database import get_session

router = APIRouter(prefix="/movies", tags=["Movies"])

@router.post("/")
def create_movie(movie: MovieCreate, session: Session = Depends(get_session)):
    db_movie = Movie(**movie.dict(), media_type="movie")
    session.add(db_movie)
    session.commit()
    session.refresh(db_movie)
    return db_movie

@router.get("/")
def list_movies(session: Session = Depends(get_session)):
    return session.exec(select(Movie)).all()

@router.get("/{movie_id}")
def get_movie(movie_id: int, session: Session = Depends(get_session)):
    movie = session.get(Movie, movie_id)
    if not movie:
        raise HTTPException(404, "Movie not found")
    return movie

@router.put("/{movie_id}")
def update_movie(movie_id: int, movie_update: MovieUpdate, session: Session = Depends(get_session)):
    movie = session.get(Movie, movie_id)
    if not Movie: 
        raise HTTPException(status_code=404, detail="Movie not found")

    for key, value in movie_update.dict(exclude_unset=True).items():
        setattr(movie, key, value)

    session.add(movie)
    session.commit()
    session.refresh(movie)
    return movie

@router.delete("/{movie_id}")
def delete_movie(movie_id: int, session: Session = Depends(get_session)):
    movie = session.get(Movie, movie_id)
    if not movie:
        raise HTTPException(404, "Movie not found")
    session.delete(movie)
    session.commit()
    return {"message": "Deleted"}


