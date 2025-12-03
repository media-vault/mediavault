from typing import Optional
from sqlmodel import SQLModel, Field

class Media(SQLModel):
    id: Optional[int] = Field(default=None, primary_key=True)
    title: str
    description: Optional[str] = None
    year: Optional[str] = None
    poster_url: Optional[str] = None
    media_type: str 

class Movie(Media, table=True):
    director: Optional[str] = None
    media_type: str = "movie"

class TVShow(Media, table=True):
    seasons: Optional[str] = None
    media_type: str = "tvshow"

class Game(Media, table=True):
    platform: Optional[str] = None
    media_type: str = "game"

