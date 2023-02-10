package gromov.ramdomusertestcase.core.extension

import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.mapLatest

@OptIn(ExperimentalCoroutinesApi::class)
inline fun <T, R> Flow<Iterable<T>>.mapLatestIterable(crossinline transform: (T) -> R): Flow<List<R>> =
    mapLatest { it.map(transform) }